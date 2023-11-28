import { Genre } from "./genre.model";
import { Image } from "./image.model";
export class Film {
  idFilm!: number;
  nomFilm!: string;
  descriptionFilm!: string;
  dateCreation!: Date;
  genre!: Genre;
  image!: Image;
  imageStr!: string;
}
