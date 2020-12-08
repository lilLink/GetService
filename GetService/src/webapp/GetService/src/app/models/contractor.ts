import { CurrentContract } from './current-contract';
import { FinishedContract } from './finished-contract';
import { Skill } from './skill.model';
import { StartedContract } from './started-contract';
import { User } from './user';

export class Contractor{
    id: number;
    user: User;
    currentContracts: CurrentContract[];
    finishedContracts: FinishedContract[];
    skills: Skill[];
    strartedContract: StartedContract;
}