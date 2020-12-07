import { Component, OnInit } from '@angular/core';
import {Cart} from "../../model/Cart";
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

    // @ts-ignore
    carts: Cart[];

    constructor(private cartService: CartService) {
    }



    ngOnInit(): void {
        this.cartService.findAll().subscribe(data => {
            this.carts = data;
        });
    }

}
