require 'benchmark'
require './assorted'

# Add a method to Array to randomize the elements
class Array
  def randomize
    a = self.dup
    a.map { a.slice!(rand a.size) }
  end
end

sorted = (1..5000).to_a
reversed = sorted.reverse
randomized = sorted.randomize
trials = 5

puts "For pre-sorted arrays, running #{trials} times each:"
Benchmark.bm(13) do |x|
  x.report("qsort") {trials.times do; sorted.qsort; end}
  x.report("bubble") {trials.times do; sorted.bubble_sort; end}
  x.report("insertion") {trials.times do; sorted.insertion_sort; end}
  x.report("selection") {trials.times do; sorted.selection_sort; end}
  x.report("merge") {trials.times do; sorted.merge_sort; end}
end

puts "For fully reversed arrays, running #{trials} times each:"
Benchmark.bm(13) do |x|
  x.report("qsort") {trials.times do; reversed.qsort; end}
  x.report("bubble") {trials.times do; reversed.bubble_sort; end}
  x.report("insertion") {trials.times do; reversed.insertion_sort; end}
  x.report("selection") {trials.times do; reversed.selection_sort; end}
  x.report("merge") {trials.times do; reversed.merge_sort; end}
end

puts "For randomized arrays, running #{trials} times each:"
Benchmark.bm(13) do |x|
  x.report("qsort") {trials.times do; sorted.qsort; end}
  x.report("bubble") {trials.times do; sorted.bubble_sort; end}
  x.report("insertion") {trials.times do; sorted.insertion_sort; end}
  x.report("selection") {trials.times do; sorted.selection_sort; end}
  x.report("merge") {trials.times do; sorted.merge_sort; end}
end
