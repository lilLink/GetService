import { Contract } from './contract.model';
import { Contractor } from './contractor';

export class StartedContract{
    id: number;
    contract: Contract;
    contractors: Contractor[];
}