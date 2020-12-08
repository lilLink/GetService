import { Contract } from './contract.model';
import { CurrentContract } from './current-contract';
import { FinishedContract } from './finished-contract';
import { PendingContract } from './pending-contract';
import { User } from './user';

export class Employer{
    id: number;
    user: User;
    pendingContracts: PendingContract[];
    currentContracts: CurrentContract[];
    finishedContracts: FinishedContract[];
    contract: Contract;
}