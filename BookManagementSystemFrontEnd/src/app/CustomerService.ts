import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CustomerDetailsDto } from './Model/CustomerDetails';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8082/api/';

  constructor(private http: HttpClient) { }

  getEmployee(id: number): Observable<Object> {
    
    return this.http.get(`${this.baseUrl}findCustomer/${id}`);
  }

  createEmployee(customer: Object): Observable<Object> {
  
    return this.http.post(`${this.baseUrl}createCustomer`,customer);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
  
    return this.http.put(`${this.baseUrl}updateCustomer/${id}`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    
    console.log(id);
    return this.http.delete(`${this.baseUrl}deleteCustomer/${id}`, { responseType: 'text' });
  }

  getEmployeesList(){

    
    return this.http.get<CustomerDetailsDto>(`${this.baseUrl}`+'AllCustomers');

  
  }
}