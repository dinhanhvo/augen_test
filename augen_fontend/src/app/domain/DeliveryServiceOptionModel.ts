export class DeliveryServiceOptionModel {
    value: number;
    label: string;
    cost: number;
    type: number;

    getCaption(): string {
        return this.label + this.cost;
    }
}