import { TrainerDTO } from './trainer-dto';

describe('TrainerDTO', () => {
  it('should create an instance', () => {
    expect(new TrainerDTO(" ", 23, " ", " ")).toBeTruthy();
  });
});
