import { Contract } from './contract';
import { Employer } from './employer';

export class PendingContract{
    id: number;
    contract: Contract;
    employer: Employer;
}