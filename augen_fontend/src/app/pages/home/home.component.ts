import { Component, OnInit } from '@angular/core';
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

  constructor(private bookService: BookService) { }

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
          return book;
        });

        console.log(this.books);
        
      },
      err => {
        console.log('getBooks error', err);
      }
    )
  }

  onBookSelected(event) {
    this.selectedBook = event;
    console.log('selectedBook: ', this.selectedBook);
  }
}
