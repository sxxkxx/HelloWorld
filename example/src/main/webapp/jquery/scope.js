/**
 * scope.js
 */

var age = 10; // 전역변수
console.log(age);
{
	let age = 20;
	console.log(age);
}
var age2 = 30;

var localFnc = function(){
//function localFnc() {
	age2 = 40;
	console.log(age2);
	age2 = 50;
}
localFnc();

console.log(age2);



const obj = {
	name:"손흥민",
	age:32,
	info:function(){
		return `이름은 ${this.name},나이는 ${this.age}입니다.`;
	}
}
console.log(obj.name);
console.log(obj.info());


class Person{
	constructor(name,age){
		this.name = name;
		this.age = age;
	}
	
	showInfo(){
		return `이름은 ${this.name},나이는 ${this.age}입니다.`;
	}
}

const p1 = new Person("이강인",24);

console.log(p1.showInfo());

Person.prototype.showName = function(){
	return this.name;
}
console.log(p1.showName());