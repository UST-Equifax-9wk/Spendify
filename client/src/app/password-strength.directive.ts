import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';

@Directive({
  selector: '[passwordStrength]',
  standalone: true,
  providers: [
    { 
      provide: NG_VALIDATORS, 
      useExisting: PasswordStrengthDirective, 
      multi: true, 
    }
  ],
})
export class PasswordStrengthDirective implements Validator {
  validate(control: AbstractControl): ValidationErrors | null {
    const value: string = control.value || '';
    const hasUpperCase = /[A-Z]+/.test(value);
    const hasLowerCase = /[a-z]+/.test(value);
    const hasNumeric = /\d+/.test(value);
    const passwordValid = hasUpperCase && hasLowerCase && hasNumeric;
    return !passwordValid ? { passwordStrength:{ hasLowerCase, hasNumeric, hasUpperCase }} : null;
  }


}
