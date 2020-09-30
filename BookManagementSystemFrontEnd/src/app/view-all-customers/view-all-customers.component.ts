import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CustomerService } from '../CustomerService';
import { CustomerDetailsDto } from '../Model/CustomerDetails';



@Component({
  selector: 'app-view-all-customers',
  templateUrl: './view-all-customers.component.html',
  styleUrls: ['./view-all-customers.component.css']
})
export class ViewAllCustomersComponent implements OnInit {

  

  constructor(private customerService: CustomerService,private router:Router) {

     this.getCustomerDetails();


   }

  ngOnInit():void {

   
  }
   customers;
  getCustomerDetails()
  {
    this.customerService.getEmployeesList().subscribe((data) => {

      this.customers = data;
      console.log(this.customers);
    }, error => {
      console.log(error);
      
    });
  }
 
  deleteCustomer(id: number) {
    this.customerService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.getCustomerDetails();
        },
        error => console.log(error));
  }

}