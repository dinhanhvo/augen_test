import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookModel } from 'src/app/domain/BookModel';
import { BuyingConfirmContext } from 'src/app/domain/BuyingConfirmKeysContext';
import { BookService } from 'src/app/services/BookService';
import { BuyService } from 'src/app/services/BuyService';

@Component({
  selector: 'app-buy-confirm',
  templateUrl: './buy-confirm.component.html',
  styleUrls: ['./buy-confirm.component.css']
})
  
export class BuyConfirmComponent implements OnInit {

  confirmedBook: BookModel;
  buyConfirmContext: BuyingConfirmContext;

  constructor(
    private route: ActivatedRoute,
    private bookService: BookService,
    private buyService: BuyService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const idDeliveryInfo = this.route.snapshot.paramMap.get('id');
    console.log('------infoId: ' + idDeliveryInfo);
    
    this.buyService.getCofirmedDeliveryInfo(idDeliveryInfo).subscribe(
      res => {
        this.buyConfirmContext = res.data;
        console.log('-----------buyConfirmContext-----', this.buyConfirmContext);
      },
      err => {
        console.log('-----------Error');
      }
    );
  }

  buyContinue() {
    this.router.navigate(['/home']);
  }

}
