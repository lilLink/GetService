import {Feedback} from './feedback.model';
import { Skill } from './skill.model';
import { UserInfo } from './userinfo.model';

export class Contract{
    contractId: number;
    price: BigInteger;
    description: string;
    neededSkills: Skill[] = [];
    //userInfo: UserInfo = new UserInfo();
}