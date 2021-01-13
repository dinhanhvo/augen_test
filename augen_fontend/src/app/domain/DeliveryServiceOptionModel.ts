export class DeliveryServiceOptionModel {
    value: number;
    label: string;
    cost: number;

    getCaption(): string {
        return this.label + this.cost;
    }
}