import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { CustomerNewComponent } from './components/customer-new/customer-new.component';
import { CustomerDetailComponent } from './components/customer-detail/customer-detail.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    CustomerNewComponent,
    CustomerDetailComponent,
    CustomerListComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
