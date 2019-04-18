export class Page {
   
    size: number = 0;
  
    totalElements: number = 0;
    
    totalPages: number = 0;
 
    page: number = 0;
    constructor() {
        this.page = 0;
        this.size = 10;
    }
}