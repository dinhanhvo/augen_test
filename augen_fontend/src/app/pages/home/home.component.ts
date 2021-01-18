import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookModel } from 'src/app/domain/BookModel';
import { BuyingConfirmKeys, BuyingConfirmContext } from 'src/app/domain/BuyingConfirmKeysContext';
import { DeliveryServiceOptionModel } from 'src/app/domain/DeliveryServiceOptionModel';
import { TimeFactorOptionModel } from 'src/app/domain/TimeFactorOptionModel';
import { BookService } from 'src/app/services/BookService';
import { BuyService } from 'src/app/services/BuyService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loading: boolean = false;

  books: BookModel[] = [];
  selectedBook: BookModel;
  displayDialog: boolean = false;
  searchText = '';

  timeFactors: TimeFactorOptionModel[] = [];
  selectedTimeFactor: TimeFactorOptionModel;

  deliveryservices: DeliveryServiceOptionModel[] = [];
  selectedDeliveryService: DeliveryServiceOptionModel;

  cost: number = 0;
  buyConfirmKeys: BuyingConfirmKeys[] = []; //BuyingConfirmKeys;
  buyConfirmContext: BuyingConfirmContext;

  constructor(
    private bookService: BookService,
    private buyService: BuyService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.getBookData();
    this.initFormData();
  }

  initFormData() {
    this.timeFactors = [];
    this.deliveryservices = [];

    this.buyService.getFactors().subscribe(
      res => {
        this.timeFactors = res.data;
        this.selectedTimeFactor = this.timeFactors[0];
      },
      err => {
        console.log('get factors error', err);
      }
    )
    this.buyService.getDeliveryServices().subscribe(
      res => {
        this.deliveryservices = res.data;
        this.selectedDeliveryService = this.deliveryservices[0];
      },
      err => {
        console.log('get deliveryservices error', err);
      }
    )
  }

  getBookData() {
    this.loading = true;
    this.bookService.getBooks(this.searchText).subscribe(
      res => {
        const items: any[] = JSON.parse(res.data).items; 
        if (items === undefined || items.length === 0) {
          this.books = [];
        } else {
          this.books = this.mapBookObject(items);
        }
        // console.log(this.books);
        this.loading = false;
      },
      err => {
        console.log('getBooks error', err);
        this.loading = false;
      }
    )
  }
  search() {
    this.getBookData();
  }

  mapBookObject(items: any[]) {
    if (items === undefined || items.length === 0) {
      return [];
    } 
    return items.map(item => {
      let book: BookModel = new BookModel();
      if (item.volumeInfo) {
        book.id = item.id;
        book.title = item.volumeInfo.title;
        book.author = item.volumeInfo.authors;
        book.imageLinks = item.volumeInfo.imageLinks;
        book.publishedDate = item.volumeInfo.publishedDate;
        book.description = item.volumeInfo.description;
      }
      return book;
    });
  }

  onBookSelected(event) {
    this.selectedBook = event;
    console.log('selectedBook: ', this.selectedBook);
    this.getAdjustCost();
    this.displayDialog = true;
  }

  buy() {
    this.displayDialog = false;
    this.buyService.confirmBuying(this.buyConfirmKeys).subscribe(
      res => {
        // this.buyConfirmContext = res.data;
        const idDeliveryInfo = res.data;
        this.router.navigate(['confirm',  idDeliveryInfo]);
      },
      err => {
        console.log('get getAdjustCost error', err);
      }
    );
    
  }

  changeFactor() {
    console.log('---changeFactor----selectedTimeFactor: ', this.selectedTimeFactor);
    this.getAdjustCost();
  }
  
  changeDeliveryService() {
    this.getAdjustCost();
  }
  
  getAdjustCost() {
    console.log('---getAdjustCost----selectedTimeFactor: ', this.selectedTimeFactor);
    console.log('---getAdjustCost----selectedDeliveryService: ', this.selectedDeliveryService);
    const costKey: BuyingConfirmKeys =  {
      deliveryServiceType: this.selectedDeliveryService.type,
      timeFactorType: this.selectedTimeFactor.type,
      cost: this.selectedDeliveryService.cost,
      bookId: this.selectedBook.id
    }
    this.buyService.getAdjustCost(costKey).subscribe(
      res => {
        this.buyConfirmKeys = res.data;
      },
      err => {
        console.log('get getAdjustCost error', err);
      }
    )
  }


}
