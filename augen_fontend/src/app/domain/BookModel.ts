
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
    description: string;

    constructor() {
        this.imageLinks = new ImageLink();
    }
}
