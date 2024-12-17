import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  
  private searchQuerySource = new Subject<string>();

 
  searchQuery$ = this.searchQuerySource.asObservable();

  
  sendSearchQuery(query: string): void {
    this.searchQuerySource.next(query);
  }
}
