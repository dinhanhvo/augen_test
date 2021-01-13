import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookModel } from 'src/app/domain/BookModel';
import { BookService } from 'src/app/services/BookService';

@Component({
  selector: 'app-buy-confirm',
  templateUrl: './buy-confirm.component.html',
  styleUrls: ['./buy-confirm.component.css']
})
export class BuyConfirmComponent implements OnInit {

  confirmedBook: BookModel;

  constructor(
    private route: ActivatedRoute,
    private bookService: BookService,
  ) { }

  ngOnInit(): void {
    const bookId = this.route.snapshot.paramMap.get('id');
    this.bookService.getBook(bookId).subscribe(
      res => {
        this.confirmedBook = res.data;
        console.log('-----------confirmedBook-----', this.confirmedBook);
      },
      err => {
        console.log('-----------Error');
      }
    );
  }

}
