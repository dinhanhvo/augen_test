import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { BookModel } from 'src/app/domain/BookModel';

@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.css']
})
export class BookCardComponent implements OnInit {

  @Input() book: BookModel;
  @Output() outputData: EventEmitter<any> = new EventEmitter();
  // @Input() counter: number = 0;
  // @Output() counterChange = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
    console.log('book info: ', this.book);
    
  }

  emitData(): void {
    this.outputData.emit(this.book);
  }

}
