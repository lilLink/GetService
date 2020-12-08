import { Contract } from './contract.model';
import { Employer } from './employer';

export class PendingContract{
    id: number;
    contract: Contract;
    employer: Employer;
}