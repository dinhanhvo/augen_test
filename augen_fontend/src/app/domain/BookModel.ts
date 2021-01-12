
export class ImageLink {
    smallThumbnail: string;
    thumbnail: string;
    constructor() {
        this.smallThumbnail = '';
        this.thumbnail = '';
    }
}

export class BookModel {
    id: string;
    title: string;
    author: string[];
    publishedDate: Date;
    imageLinks: ImageLink;

    constructor() {
        this.imageLinks = new ImageLink();
    }
}
