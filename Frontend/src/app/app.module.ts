import { UpdateFilmComponent } from "./update-film/update-film.component";
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { HttpClientModule } from "@angular/common/http";
import { HTTP_INTERCEPTORS } from "@angular/common/http";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { FilmComponent } from "./film/film.component";
import { AddFilmComponent } from "./add-film/add-film.component";
import { FormsModule } from "@angular/forms";
import { RechercheGenreComponent } from "./recherche-genre/recherche-genre.component";
import { ListeGenreComponent } from "./liste-genre/liste-genre.component";
import { UpdateGenreComponent } from "./update-genre/update-genre.component";
import { LoginComponent } from "./login/login.component";
import { ForbiddenComponent } from "./forbidden/forbidden.component";
import { RechercheParNomComponent } from "./recherche-par-nom/recherche-par-nom.component";
import { SearchFilterPipe } from "./search-filter.pipe";
import { TokenInterceptor } from "./services/token.interceptor";
import { RegisterComponent } from "./register/register.component";
import { AddRoleToUserComponent } from "./add-role-to-user/add-role-to-user.component";
import { UsersComponent } from "./users/users.component";

@NgModule({
  declarations: [
    AppComponent,
    FilmComponent,
    AddFilmComponent,
    UpdateFilmComponent,
    RechercheGenreComponent,
    ListeGenreComponent,
    UpdateGenreComponent,
    LoginComponent,

    ForbiddenComponent,
    RechercheParNomComponent,
    SearchFilterPipe,
    RegisterComponent,
    AddRoleToUserComponent,
    UsersComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
  ],

  bootstrap: [AppComponent],
})
export class AppModule {}
