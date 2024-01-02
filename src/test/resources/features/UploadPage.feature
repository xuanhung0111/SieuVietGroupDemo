Feature: Uploading functionality

  Scenario: Verify default maximum file size is 196.45 MB
    Given visit the upload page
    Then check maximum file size

  Scenario: We can upload valid file successful without errors
    Given visit the upload page
    When select file input
    And click submit button
    Then check that file can upload successful

  Scenario: Upload file with checked terms successful
    Given visit the upload page
    When select file input
    And click submit button
    And checked in the term checkbox
    Then check that file can upload successful

  Scenario Outline: Upload with different file sizes and file types are successful
    Given visit the upload page
    When select file input name is "<fileName>"
    And click submit button
    And checked in the term checkbox
    Then check that file can upload successful
    Examples:
      | fileName |
      | testFileSize_10kbytes.xml |
      | testFileSize_10MB.xml |
      | testFileSize_195MB.xml |
      | testFile.csv |
      | testFile.jpeg |
      | testFile_10kbyes.jar |
      | testFile_113bytes.xml |
      | testFile_133MB.dmg |

  Scenario Outline: Cannot upload big file size > 196.45MB
    Given visit the upload page
    When select file input name is "<fileName>"
    And click submit button
    And checked in the term checkbox
    Then check that file cannot upload successful
    Examples:
      | fileName |
      | testFile_300MB.xml |
      | testFile_300MB.dmg|

  Scenario Outline: Upload with file with special file names
    Given visit the upload page
    When select file input name is "<fileName>"
    And click submit button
    Then check that file can upload successful
    Examples:
      | fileName |
      | 123!@!23.xml |
      | ! !23 !2~2).xml|
