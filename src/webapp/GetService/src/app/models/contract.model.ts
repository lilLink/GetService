import {Feedback} from './feedback.model';
import {Employer} from './employer.model';

export class Contract{
    contractId: number;
    employers: Employer[] = [];
    price: number;
    description: string;
    neededSkills: string[] = [];
    feedbacks: Feedback[] = [];
}