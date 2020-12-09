import {Role} from "../roles/Role";

export class User {

    email: string;

    password: string;

    username: string;

    phone: string;

    address: string;

    active: boolean;

    role: string;

    constructor(){
        this.active = true;
        this.role = Role.USER;
    }
}