import { Contract } from './contract.model';
import { UserInfo } from './userinfo.model';


export class Feedback{
    feedbackId: number;
    comment: string;
    contract: Contract;
    userInfo: UserInfo;
}