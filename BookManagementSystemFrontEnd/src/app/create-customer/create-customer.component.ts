import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../CustomerService';
import { CustomerDetailsDto } from '../Model/CustomerDetails';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customer: CustomerDetailsDto = new CustomerDetailsDto();
  submitted = false;


  constructor(private customerService:CustomerService ) { }

  ngOnInit(): void {
  }

  newCustomer(): void {
    this.submitted = false;
    this.customer = new CustomerDetailsDto();
  }

  save() {
    this.customerService.createEmployee(this.customer)
      .subscribe(data => console.log(data), error => console.log(error));
    this.customer = new CustomerDetailsDto;
  }


  onSubmit() {
    this.submitted = true;
    this.save();
  }



}
