import { UserInfo } from './userinfo.model';


export class User{
    userId: number;
    email: string;
    password: string;
    role: string;
    userInfo: UserInfo;
}