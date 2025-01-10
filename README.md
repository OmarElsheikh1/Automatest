# Automatest: Test Automation Training Round 28 Practice Project

This is a test change.

## Rules of XPath

**Relative XPath:**

- `//tagName[@attribute='value']`
- `//tagName[@attribute]`
- `//tagName`
- `//tagName[@attribute='value'][@attribute2='value2']`
- `//tagName[@attribute='value'][index]`
- `(//tagName[@attribute='value'][@attribute2='value2'])[index]`
- `//*[@attribute='value']`
- `//parentTagName[@attribute='value']/tagName[@attribute='value']`
- `//grandParentTagName[@attribute='value']//tagName[@attribute='value']`
- `//tagName[contains(@attribute,'subValue')]`
- `//tagName[not(contains(@attribute,'subValue'))]`
- `//tagName[text()='element text']`
- `//tagName[contains(text(),'partial text')]`
- `//tagName[contains(.,'partial text')]`
- `//section[not(contains(@class, 'shrink'))]/a/img`

### Factors of a Good/Stable XPath:
- Number of nodes
- Number of attributes
- Stability of values
- Using index sparingly (Automation Hell)
- Avoid using class equals (especially with multiple classes), use class contains instead
- Maps to business requirements
- Do not use text to identify elements in a website that supports multiple languages

## Rules of Test Structure

**Test Cases:**
- Test class should be created per module
- One test method per test case
- Before/after method for setup/teardown
- Test case should start with navigation
- Test case should end with assertion
- [Test cases should be independent]

**Test Scenarios:**
- Test package per module
- Test class per scenario
- Before/after class for setup/teardown
- Navigation in the before class
- Test case should end with assertion
- [Test cases should be dependent]
