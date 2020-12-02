import { Category } from './category';
import { Contract } from './contract';
import { Contractor } from './contractor';

export class Skill{
    id: number;
    name: string;
    category: Category;
    contract: Contract;
    contractor: Contractor;
}