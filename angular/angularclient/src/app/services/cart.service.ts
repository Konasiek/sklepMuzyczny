import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cart} from "../model/Cart";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private productUrl: string;

  constructor(private http: HttpClient) {
    this.productUrl = 'http://localhost:8080/cart';


  }

  public findAll(): Observable<Cart[]> {
    return this.http.get<Cart[]>(this.productUrl);
  }

  public save(product: Cart) {
    return this.http.post<Cart>(this.productUrl, product);
  }
}
