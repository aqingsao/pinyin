var luhn = function () {
  var delta = [0, 1, 2, 3, 4, -4, -3, -2, -1, 0];
  var toIntArray = function(number){
    var ret = number.split("");
    for (i = 0; i < ret.length; i++) {
      ret[i] = parseInt(ret[i]);
    }
    return ret;
  };
  return {
    sum: function(number){
      var total = 0;
      var intArray = toIntArray(number);
      for (i = 0; i < intArray.length; i++) {
        total += intArray[i];
        if((intArray.length - i) % 2 == 1){
          total += delta[intArray[i]];
        }
      }
      total = total % 10;
      return total == 0 ? 0 : 10 - total;
    },
    isValid:function (number) {
      var luhnDigit = parseInt(number.substring(number.length - 1, number.length));
      return this.sum(number.substring(0, number.length - 1)) == luhnDigit;
    }
  }
}();

