import { Role } from './role';
import { User } from './user';

export class UserInfo{
    id: number;
    firstName: string;
    lastName: string;
    user: User;
    role: Role;
}