function(f) {
  var clone = this.clone();
  clone.sortInPlace();
  return ArraySequence(clone,{Element$ArraySequence:{t:this._elemTarg()}});
}
