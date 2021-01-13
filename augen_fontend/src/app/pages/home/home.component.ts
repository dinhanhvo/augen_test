import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SelectItem } from 'primeng-lts/api';
import { BookModel } from 'src/app/domain/BookModel';
import { BookService } from 'src/app/services/BookService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  books: BookModel[] = [];
  selectedBook: BookModel;
  displayDialog: boolean = false;

  timeFactors: SelectItem[] = [];
  selectedTimeFactor: SelectItem;

  constructor(private bookService: BookService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.bookService.getBooks().subscribe(
      res => {
        let items: any[] = JSON.parse(res.data).items; 
        this.books = items.map(item => {
          let book: BookModel = new BookModel();
          book.id = item.id;
          book.title = item.volumeInfo.title;
          book.author = item.volumeInfo.authors;
          book.imageLinks = item.volumeInfo.imageLinks;
          book.publishedDate = item.volumeInfo.publishedDate;
          book.description = item.volumeInfo.description;
          return book;
        });

        console.log(this.books);
        
      },
      err => {
        console.log('getBooks error', err);
      }
    )
    this.initFormData();
  }

  initFormData() {
    this.timeFactors = [
      { label: '68', value:1},
      { label: '9', value:2},
      {label: 'other', value:3}
    ];
  }

  onBookSelected(event) {
    this.selectedBook = event;
    console.log('selectedBook: ', this.selectedBook);
    this.displayDialog = true;
  }

  buy() {
    this.displayDialog = false;
    console.log('routing to confirm page: ', this.selectedBook.id);
    this.router.navigate(['confirm',  this.selectedBook.id]);
  }
}
