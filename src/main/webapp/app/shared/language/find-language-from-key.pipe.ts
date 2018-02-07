import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'findLanguageFromKey'})
export class FindLanguageFromKeyPipe implements PipeTransform {
    private languages: any = {
        'zh-cn': { name: '中文（简体）' },
        'en': { name: 'English' },
        'fr': { name: 'Français' },
        'hi': { name: 'हिंदी' },
        'ja': { name: '日本語' },
        'es': { name: 'Español' }
        // jhipster-needle-i18n-language-key-pipe - JHipster will add/remove languages in this object
    };
    transform(lang: string): string {
        return this.languages[lang].name;
    }
}
