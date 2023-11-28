import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { FilmService } from "../services/film.service";
import { Film } from "../model/film.model";
import { Genre } from "../model/genre.model";
import { Image } from "../model/image.model";
@Component({
  selector: "app-update-film",
  templateUrl: "./update-film.component.html",
  styleUrls: ["./update-film.component.css"],
})
export class UpdateFilmComponent implements OnInit {
  currentFilm = new Film();
  Genre!: Genre[];
  updatedGenreId!: number;
  uploadedImage!: File;
  isImageUpdated: Boolean = false;
  apiurl: string = "http://localhost:8080/Film/api/image";
  myImage: string = "";

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private filmService: FilmService
  ) {}

  ngOnInit(): void {
    this.filmService.listeGenre().subscribe((gen) => {
      this.Genre = gen._embedded.genres;
      console.log(gen);
    });
    this.filmService
      .consulterFilm(this.activatedRoute.snapshot.params["id"])
      .subscribe((f) => {
        this.currentFilm = f;
        this.updatedGenreId = f.genre.idGenre;
        this.filmService
          .loadImage(this.currentFilm.image.idImage)
          .subscribe((img: Image) => {
            this.myImage = "data:" + img.type + ";base64," + img.image;
          });
      });
  }

  getFilmImageUrl(Film: Film): string {
    return `${this.apiurl}/load/${Film.image.idImage}`;
  }
  updateFilm() {
    this.currentFilm.genre = this.Genre.find(
      (gen) => gen.idGenre == this.updatedGenreId
    )!;
    if (this.isImageUpdated) {
      this.filmService
        .uploadImage(this.uploadedImage, this.uploadedImage.name)
        .subscribe((img: Image) => {
          this.currentFilm.image = img;
          this.filmService.updateFilm(this.currentFilm).subscribe((prod) => {
            this.router.navigate(["Film"]);
          });
        });
    } else {
      this.filmService.updateFilm(this.currentFilm).subscribe((f) => {
        this.router.navigate(["Film"]);
      });
    }
  }
  onImageUpload(event: any) {
    if (event.target.files && event.target.files.length) {
      this.uploadedImage = event.target.files[0];
      this.isImageUpdated = true;
      const reader = new FileReader();
      reader.readAsDataURL(this.uploadedImage);
      reader.onload = () => {
        this.myImage = reader.result as string;
      };
    }
  }
}
