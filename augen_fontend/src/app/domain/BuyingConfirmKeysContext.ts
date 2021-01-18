export class BuyingConfirmKeys {
    deliveryServiceType: number;
    timeFactorType: number;
    cost: number;
    bookId: string;
}

export class BuyingConfirmContext {
    bookId: string;
    delyDeliveryService: any;
    timeFactor: any;
    cost: number;
}