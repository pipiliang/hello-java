import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppRouter } from './app.router';

import { AppComponent } from './app.component';
import {NgZorroAntdModule} from "ng-zorro-antd";
import {TriggerLayoutComponent} from "./layout/layout.component";
import {DashboardComponent} from "./routers/dashboard/dashboard.component";
import {AboutComponent} from "./routers/about/about.component";

@NgModule({
  declarations: [
    AppComponent,
    TriggerLayoutComponent,
    DashboardComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRouter,
    NgZorroAntdModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
