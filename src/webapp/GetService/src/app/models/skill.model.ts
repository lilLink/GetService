import { from } from 'rxjs';
import { Contract } from './contract.model';

export class Skill{
    skillId: number;
    skillName: string;
    skillDescription: string;
    contract: Contract = new Contract();
}