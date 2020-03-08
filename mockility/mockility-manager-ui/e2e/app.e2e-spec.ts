import { MockilityUiPage } from './app.po';

describe('mockility-ui App', () => {
  let page: MockilityUiPage;

  beforeEach(() => {
    page = new MockilityUiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
