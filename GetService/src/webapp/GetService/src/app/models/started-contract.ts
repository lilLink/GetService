import { Contract } from './contract';
import { Contractor } from './contractor';

export class StartedContract{
    id: number;
    contract: Contract;
    contractors: Contractor[];
}