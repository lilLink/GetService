import { Employer } from './employer';
import { Skill } from './skill';

export class Contract{
    id: number;
    employers: Employer[];
    price: number;
    description: string;
    neededSkills: Skill[];
}