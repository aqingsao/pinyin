describe("calculate luhn sum for given values", function() {
  it("return 3 when given a number", function() {
    expect(luhn.sum("7992739871")).toEqual(3);
  });
  it("return different luhn digits when typo 1 digit", function() {
    expect(luhn.sum("7992739871")).toNotEqual(luhn.sum("7992739870"));
  });
  it("return different luhn digits when there are transpositions of adjacent digits", function() {
    expect(luhn.sum("7992739871")).toNotEqual(luhn.sum("7992739817"));
  });
  it("return different luhn digits when there are twin errors", function() {
    expect(luhn.sum("7992739800")).toNotEqual(luhn.sum("7992739811"));
  });
  it("return different luhn digits when there are twin errors", function() {
    expect(luhn.sum("7992739822")).toEqual(luhn.sum("7992739855"));
  });
});
describe("cannot tell difference when there are special error cases", function() {
  it("return same luhn digits when there are transpositions of adjacent digits for 2-digit number", function() {
    expect(luhn.sum("09")).toEqual(luhn.sum("90"));
  });
  it("return same luhn digits when there are twin errors from 22 to 55", function() {
    expect(luhn.sum("7992739822")).toEqual(luhn.sum("7992739855"));
  });
  it("return same luhn digits when there are twin errors from 33 to 66", function() {
    expect(luhn.sum("7992739833")).toEqual(luhn.sum("7992739866"));
  });
  it("return same luhn digits when there are twin errors from 44 to 77", function() {
    expect(luhn.sum("7992739844")).toEqual(luhn.sum("7992739877"));
  });
});

describe("check whether lumn sum is correct", function() {
  it("return false when given incorrect luhn number ", function() {
    expect(luhn.isValid("79927398710")).toEqual(false);
  });

  it("return true when given correct luhn number ", function() {
    expect(luhn.isValid("79927398713")).toEqual(true);
  });

});
