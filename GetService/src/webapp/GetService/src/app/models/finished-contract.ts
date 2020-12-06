import { Contractor } from './contractor';
import { Employer } from './employer';
import { Feedback } from './feedback';
import { StartedContract } from './started-contract';

export class FinishedContract{
    id: number;
    startedContract: StartedContract;
    feedback: Feedback;
    contractor: Contractor;
    employer: Employer;
}