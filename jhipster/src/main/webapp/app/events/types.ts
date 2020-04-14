interface EventInterface {
  id:string;
  status: 'accepted' | 'invited';
  title: string;
  owner: string;
  desc: string;
}
