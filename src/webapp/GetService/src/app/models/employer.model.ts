import {Contract} from './contract.model';
import {User} from './user.model';

export class Employer{
    employerId: number;
    user: User;
    contract: Contract;
}