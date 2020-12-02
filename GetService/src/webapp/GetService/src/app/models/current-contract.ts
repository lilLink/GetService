import { Contractor } from './contractor';
import { Employer } from './employer';
import { StartedContract } from './started-contract';

export class CurrentContract{
    id: number;
    startedContract: StartedContract;
    contractor: Contractor;
    employer: Employer;
}