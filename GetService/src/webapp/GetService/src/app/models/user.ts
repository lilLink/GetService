import { Contractor } from './contractor';
import { Employer } from './employer';
import { UserInfo } from './user-info';

export class User{
    id: number;
    email: string;
    password: string;
    userInfo: UserInfo;
    employer: Employer;
    contractor: Contractor;
}