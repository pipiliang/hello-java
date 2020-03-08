import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {DashboardComponent} from "./routers/dashboard/dashboard.component";
import {AboutComponent} from "./routers/about/about.component";
import {RegisterComponent} from "./routers/management/register/register.component";

const appRoutes: Routes = [
    {path: '', component: DashboardComponent},
    {path: 'dashboard', component: DashboardComponent},
    {path: 'about', component: AboutComponent},
    {path: 'register', component: RegisterComponent}
];
@NgModule({
    imports: [
        RouterModule.forRoot(appRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRouter {
}